require('dotenv').config();
var express = require('express');
var Xbox = require('xbox-on');
var app = express();

if (!process.env.XBOX_IP || !process.env.XBOX_LIVE_DEVICE_ID) {
  console.error("Invalid command line args. Usage: node app.js -i <IP> -d <Device Live ID>");
  return;
}

var xbox = new Xbox(process.env.XBOX_IP, process.env.XBOX_LIVE_DEVICE_ID); 

app.get('/xbox', function (req, res) {
  console.log('Powering Xbox on...');
  xbox.powerOn();
  res.send('ACK');
})

app.listen(80, function () {
  console.log('Listening on port 80!')
})