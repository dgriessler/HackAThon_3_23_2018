import socket
import sys
import pifacecad
import struct

try:
	s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
except socket.error:
	print ('Failed to create socket')
	sys.exit()
host = '163.118.36.47';
port = 4446;

cad = pifacecad.PiFaceCAD()
isStarted = False
pieceSelected = False
def askWhichPiece(event):
	global pieceSelected
	if (isStarted == True and pieceSelected == False):
		from pifacecad.tools.question import LCDQuestion
		question = LCDQuestion(question="Select An Action", answers=["Select", "GoRight", "GoLeft"])
		answer_index = question.ask()
		try:
			string_index = str(answer_index).encode()
			s.sendto(string_index, (host, port))
			d = s.recvfrom(1024)
			reply = d[0]
			addr = d[1]
			if (struct.unpack('1B', reply[:1])[0] == 1):
				pieceSelected = True
		except (socket.error):
			sys.exit()
	else:
		print(isStarted)
		print(pieceSelected)


def askWhereToMove(event):
	global pieceSelected
	if (isStarted == True and pieceSelected == True):
		from pifacecad.tools.question import LCDQuestion
		question = LCDQuestion(question="Which Move", answers=["Left", "Down", "Up", "Right"])
		answer_index = question.ask()
		try:
			string_index = str(answer_index)
			string_index = (string_index + str(0)).encode()
			s.sendto(string_index, (host, port))
			d = s.recvfrom(1024)
			reply = d[0]
			addr = d[1]
			if (struct.unpack('1B', reply[:1])[0] == 2):
				pieceSelected = False
		except (socket.error):
			sys.exit()


def askOther(event):
	global pieceSelected
	if (isStarted == True and pieceSelected == True):
		from pifacecad.tools.question import LCDQuestion
		question = LCDQuestion(question="Other Options", answers=["Flip", "Rotate", "Go Back", "Place"])
		answer_index = question.ask()
		try:
			string_index = str(answer_index)
			string_index = (string_index + str(1)).encode()
			s.sendto(string_index, (host, port))
			d = s.recvfrom(1024)
			reply = d[0]
			addr = d[1]
			if (answer_index == 2):
				pieceSelected = False
			if (struct.unpack('1B', reply[:1])[0] == 2):
				pieceSelected = False
		except (socket.error):
			sys.exit()

def start(event):
	global isStarted;
	if (isStarted == False):
		print('start')
		msg = 'start'.encode()
		isStarted = True
		try:
			s.sendto(msg, (host, port))
			d = s.recvfrom(1024)
			reply = d[0]
			addr = d[1]
		except (socket.error):
			print ('Error Code : ' + str(msg[0]))
			sys.exit()


listener = pifacecad.SwitchEventListener(chip=cad)
listener.register(0, pifacecad.IODIR_RISING_EDGE, askWhichPiece)
listener.register(1, pifacecad.IODIR_RISING_EDGE, askWhereToMove)
listener.register(2, pifacecad.IODIR_RISING_EDGE, askOther)
listener.register(3, pifacecad.IODIR_RISING_EDGE, start)
run = True


def kill(event):
	if (isStarted == True):
		msg = 'end'.encode()
		try:
			s.sendto(msg, (host, port))
			global run
			run = False
		except (socket.error):
			print ('Error Code : ' + str(msg[0]))
			sys.exit()
listener.register(4, pifacecad.IODIR_RISING_EDGE, kill)
listener.activate()

while(1):
	if (run is False):
		listener.deactivate()
		cad.lcd.clear()
		cad.lcd.backlight_off()
		sys.exit()

		


	