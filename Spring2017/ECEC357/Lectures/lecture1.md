# Notes on network layer

## ISO Model (7 layers)

* Application
* Presentation
* Session
* Transport
* Network
* Data link
* Physical

## Internet Layer Model

* Application
* Transport (TCP or UDP)
* Network (IP)
* Data Link (LAN)
* Physical

## Terms

* Application layer generates "Message"
* Transport Layer generates "Segment(s)" by appending TCP/UDP headers
* Network Layer generates "Datagram(s)" by appending IP header
* Link Layer generates "Frame(s)" by appending link header and link trailer which performs error checking
