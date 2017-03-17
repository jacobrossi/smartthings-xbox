var express = require('express');
var Xbox = require('xbox-on');
var app = express();

app.get('/xbox', function (req, res) {
  var ip = req.query.ip;
  var device = req.query.device;
  if (!ip || !device) {
    console.error("Invalid Xbox IP or Device ID - Please specify in SmartThings Settings");
  return;
}
  var xbox = new Xbox(ip, device); 
  console.log('Powering Xbox on...\n\tXbox IP:' + ip + '\n\tLive Device ID:' + device);
  xbox.powerOn();
  res.send('ACK');
})

app.listen(80, function () {
  console.log('Listening on port 80!')
})