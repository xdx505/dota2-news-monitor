You can switch `spring.profile.active` property to `dev` value if want to make tests in your local machine with ngrok requests mirroring. 

Also, you must create `.env` file in project root `/` or near `.jar` file as an example: 
```dotenv
# Not forget to create Nginx or Apache rule for forvarding requests
# to path "https://${SERVER_HOST}:${SERVER_PORT}/${BOT_TOKEN}".
# Example: "https://192.168.1.1/123456789:UEAS1kfWE5LAS16gs9SAO1RJgf_2F-Q14"

# Web settings
# External SERVER_HOST to register in Telegram Api.
SERVER_HOST=192.168.1.1:443
# Expernal SERVER_PORT to register in Telegram Api. Only can be 80, 88, 443, 8443.
SERVER_PORT=443
# Internal SERVLET_PORT. Not forget to forward port via Nginx or Apache.
SERVLET_PORT=3222

# Bot settings
BOT_USERNAME=bot_username
BOT_TOKEN=123456789:UEAS1kfWE5LAS16gs9SAO1RJgf_2F-Q14
```
