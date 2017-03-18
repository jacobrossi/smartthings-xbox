# Xbox One SmartThings Device
Allows powering an Xbox One from SmartThings. For now, this solution requires running a small server on a computer to act as a "bridge" due to limitations in SmartThings. See #1 for more details. Based on https://github.com/arcreative/xbox-on.

## Setup
### Configure the bridge
First you must set up the "bridge" on a computer on your home network. The following steps are for a Raspberry Pi, but any Windows/Linux/Mac should do (exact steps vary by platform).
1. Install node and npm: ```sudo apt-get install nodejs npm```
2. Copy [package.json](https://github.com/jacobrossi/smartthings-xbox/blob/master/package.json) and [app.js](https://github.com/jacobrossi/smartthings-xbox/blob/master/app.js) from this repo into a folder
3. In that folder, install the dependencies: ```npm install```
4. Start the server: ```sudo nodejs app.js```

You should see ```Listening on port 80``` in the console.

### Configure the SmartThings device
1. Install [xbox.groovy](https://github.com/jacobrossi/smartthings-xbox/blob/master/xbox.groovy) as a [new Device Handler](https://community.smartthings.com/t/faq-an-overview-of-using-custom-code-in-smartthings/16772) in SmartThings.
2. Create a new device that uses the Xbox One Controller as its device type.
3. In the SmartThings app, find the new Xbox device and open up its settings. Fill out the settings as follows:
 * Bridge IP - this is the local IP address of the computer running the bridge server
 * Bridge Port - this is the port of the bridge server (default is 80)
 * Xbox IP - IP address of your Xbox
 * Xbox Live Device ID - you can find this value on your Xbox by going to Settings > System > Console info

Note: it's highly recommended that you configure the bridge computer and Xbox to have static IP addresses. Additionally, you may want to create a startup script to run the bridge in case the computer is restarted.

Disclaimer: I work for Microsoft. This project is my own and not affiliated with or endorsed by Microsoft.