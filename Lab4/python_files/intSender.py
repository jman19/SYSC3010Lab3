# Source: https://pymotw.com/2/socket/udp.html

import socket, sys, time
import random

host = sys.argv[1]
textport = sys.argv[2]
messages = sys.argv[3]

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
port = int(textport)
server_address = (host, port)

for i in range(int(messages)):
    print ("Sent Message"+str(i))
    data=bytes(random.randint(1,101))
    s.sendto(data, server_address)
    print ("waiting for response..")

    buf, address = s.recvfrom(port)
    if not len(buf):
        break
    print ("Received %s bytes from %s %s: " % (len(buf), address, buf ))

s.shutdown(1)

