# Recitation 5?
* Homework 2 Problem P27
## Part a
* seq # 207
* src 302
* dest 80
## Part b
* b->a ACK#1
* seq 127
* src 80
* dest 302
## Part c
* Ack seq #247

# Problem P37
## Part a
* GBN: sends 4 packets -> 0,1(lost), 2, 3, 4, resend 1, 2, 3, 4
* Recievee 8 acks
* SR: Sends 6 packets 0, 1(lost), 2, 3, 4 resend 1
* 5 acks
* TCP: Send 6 packets 0, 1(lost), 2, 3, 4, resend 1
* 5 acks
* TCP will have cumulative acks
