const app = require('express')();
const http = require('http').Server(app);
const io = require('socket.io')(http);
const port = process.env.PORT || 3000;

app.get('/', (req, res) => {
  res.sendFile(__dirname + '/index.html');
});

io.on('connection', (socket) => {
  // this is waiting for the message to send.
  socket.on('chat message', msg => {
    // this is what displays the message on the screen
    io.emit('chat message', msg);
    
  });
});

// this is showing whether or not someone is connected or disconnected
io.on('connection', (socket) => {
  console.log('a user connected');
  io.emit('chat message', 'User has entered the chat');
  socket.on('disconnect', () => {
    io.emit('chat message', 'A user has left the chat');
    console.log('user disconnected');
  });
});

io.sockets.on('connection', function (socket) {
  var address = socket.handshake.address;
  console.log('New connection from ' + address.address + ':' + address.port);
});

// this is saying on a connection to the socket
io.on('connection', (socket) => {
  // listening for a chat message 
  socket.on('chat message', (msg) => {
    // this is logging it to console
    console.log('message: ' + msg);
  });
});



http.listen(port, () => {
  console.log(`Socket.IO server running at http://localhost:${port}/`);
});
