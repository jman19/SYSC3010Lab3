# Source: https://pymotw.com/2/socket/udp.html

import socket, sys, time, json

host = sys.argv[1]
textport = sys.argv[2]

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
port = int(textport)
server_address = (host, port)

for i in range(10):
	x = {"name": "John","age": 30,"city": "New York"}

	# convert into JSON:
	data = json.dumps(x)
	s.sendto(data.encode('utf-8'), server_address)

s.shutdown(1)

