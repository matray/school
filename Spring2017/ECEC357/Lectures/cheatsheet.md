# Cheat Sheet for Midterm 2
## Exponential RTT
* Initial ERTT = E(0)
* First Sample RTT = S(1)
* Second Sample RTT = S(2)
* Third Sample RTT = S(3)
* Timeout(0) = 2* E(0)
---------------------------
* E(0) = E(0)
* T(0) = 2 * E(0)
---------------------------
* S(1) = S(1)
* E(1) = E(0)*0.875 + S(1)*0.125
* T(1) = 2* E(1)
---------------------------
* S(2) = S(2)
* E(2) = E(1)*0.875 + S(2) * 0.125
* T(2) = 2*E(2)
---------------------------
* etc
* Another timeout calculation is E(i) + 4*Deviation
* Deviation(i) = 0.75*Deviation(i-1) + 0.25* abs(sample(i)-E(i-1))

## TCP
* Client sends random SEQ with a SYN='1'
* Server responds with random SEQ, ack=client seq+1, SYN='1'
* Client responds with ack=server seq+1, seq=client seq+1
* Ack is one more than seq number
* Cumulative acks, so if missed ack but got a higher one, no problem
* When recieves out of order packet, client resends duplicate ack for the last packet received in order
## Buffers
* Sender:
	* SendBuffer = 1024 Bytes
	* LastByteWritten = 1184 Bytes
	* LastByteSent = 556
	* LastByteAcker = 412
* Receiver:
	* RcvBuffer = 768 Bytes
	* LastByteRead = 256 Bytes
	* LastByteAcked = 412 Bytes
* How many waiting on receiver for application
* LastByteAcked-LastByteRead = 412-256=156 Bytes
* What is size of receiver window
* RecvBuffer-(LastByteAcked-LastByteRead)=768-(412-256)=612 Bytes
* What is number of the last byte the receiver can accept?
* LastByteRead+RcvBuffer = 256+768=1024
* How many more bytes can sender safely send without reciever overflow? Basically, what is the size of senderwindows?
* Receiverwindow-(LastByteSent-LastByteAcked)=612-(556-412)=468 Bytes
* How many more bytes can the sending applicatino write into the sender buffer
* LastByteAcked+SendBuffer-LastByteWritten = 412+1024-1184 = 252 Bytes
## Time to distribute File(F) to N clients using client-server approach
* D_C-S >= max{N*F/u_s, F/d_min}
* d_min = min client download rate
* u_s = server upload capacity


# Midterm Review Questions
* Go over Q1, Q2, Q6, maybe Q7
* GBN: Cumulative Ack, out of order Discarded
* SR: Cumulative Selective Ack, out of order selective ack accepted
* TCP: Cumulative Selective Ack, out of order selective ack accepted
