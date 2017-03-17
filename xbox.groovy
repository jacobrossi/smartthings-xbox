/**
 *  SmartThings-Xbox
 *  SmartThings device to power on your Xbox One
 *
 * https://github.com/jacobrossi/smartthings-xbox
 *
 */

preferences {
	input("serverIp", "text", title: "Bridge IP", description: "The IP of the bridge (server) running the node module")
	input("serverPort", "number", title: "Bridge Port", description: "The port of the smartthings-xbox bridge (default: 80)")
	input("xboxIp", "text", title: "Xbox IP", description: "The IP of the Xbox to control")
	input("xboxDeviceId", "text", title: "Xbox Live Device ID", description: "The Xbox Live Device ID for your Xbox (found in Settings > System)")
}
 

metadata {
	definition (name: "Xbox One Controller", namespace: "JacobRossi", author: "gtjrossi@gmail.com") {
        capability "Actuator"
        capability "Switch" 
        capability "Configuration"
      	}

	tiles {
		standardTile("switch", "device.switch", width: 2, height: 2, canChangeIcon: true) {
			state "off", label: '${name}', action: "switch.on", icon: "st.switches.switch.off", backgroundColor: "#ffffff"
			state "on", label: '${name}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#79b821"
		}

		main(["switch"])
		details(["switch"])
	}
}

def parse(String description) {
	log.debug "Parsing '${description}'"
}


def on() {
    sendEvent(name: "switch", value: "on")
    log.debug "on"
    def result = new physicalgraph.device.HubAction(
        method: "GET",
        path: "/xbox?ip=" + xboxIp + "&device=" + xboxDeviceId,
        headers: [
            HOST: serverIp + ":" + serverPort
        ]
    )
    return result
}

def off() { 
    sendEvent(name: "switch", value: "off")
}