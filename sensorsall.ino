#define BLYNK_TEMPLATE_ID "TMPL3V3AWYaSZ"
#define BLYNK_TEMPLATE_NAME "Carbon Emission"
#define BLYNK_AUTH_TOKEN "31w3sTJ6zvplmt2ZTwXG3g9r5D-tqtJ2"

#define BLYNK_PRINT Serial
#include <WiFi.h>
#include <WiFiClient.h>
#include <BlynkSimpleEsp32.h>


char auth[] = "31w3sTJ6zvplmt2ZTwXG3g9r5D-tqtJ2";

char ssid[] = "vinuchai";  // type your wifi name
char pass[] = "madhumathi";  // type your wifi password
const int sensorPins[4] = {34, 33, 32, 35}; // Array of sensor analog input pins
const char* sensorNames[4] = {"MQ2", "MQ7", "MQ4", "MQ135"}; // Array of sensor names for clarity

int sensorValues[4]; // Array to store sensor readings
int sensorThresholds[4] = {1500, 700, 4200, 600}; // Adjust thresholds as needed for each sensor

BlynkTimer timer;

void sendSensorData() {
  for (int i = 0; i < 4; i++) {
    sensorValues[i] = analogRead(sensorPins[i]);
    Blynk.virtualWrite(V0 + i, sensorValues[i]); // Send data to virtual pins V0 to V3
    Serial.print(sensorNames[i]);
    Serial.print(": ");
    Serial.println(sensorValues[i]);

    if (sensorValues[i] > sensorThresholds[i]) {
       //Blynk.email("test@gmail.com", "Alert", "Gas Leakage Detected!");
       Blynk.logEvent("carbon_emission", "Air pollution level is high for" + String(sensorNames[i]));
    }
  }
}

void setup() {
  for (int i = 0; i < 4; i++) {
    pinMode(sensorPins[i], INPUT);
  }
  Serial.begin(9600);
  Blynk.begin(BLYNK_AUTH_TOKEN, ssid, pass);
  timer.setInterval(2500L, sendSensorData);
}

void loop() {
  Blynk.run();
  timer.run();
}
