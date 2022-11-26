## Web Dev Fundamentals

### Web Page Request Lifecycle

Computer -> Resolving Domain Name <-> Root Server <-> TLD Server <-> Authoritative Server <-> IP Address

### Connecting to Server

| Client                    | Server                      |
| ------------------------- | --------------------------- |
| Syn ->                    | <- Syn/Ack                  |
| Ack ->                    | (Called as 3 way handshake) |
| connection established -> | <- connection established   |
| fin ->                    | <- ack                      |
| ack ->                    | <- fin                      |
| Ack ->                    | (Connection Closed)         |

### HTTPS

Server -> Certificate + Public Key
Client -> Verify Certificate & Create Session Key 
Client -> Encrypt Session Key with Public Key
Server -> Decrypt Session Key with Private Key


