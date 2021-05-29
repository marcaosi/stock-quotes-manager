# stock-quotes-manager
stock-quotes-manager

Execute to run:
   docker-compose up --build --force-recreate


## Endpoints

### POST
* /stock


example body :

{
	"id": "ITUB4",
	"quotes": [
		{
			"value": 10,
			"date": "2021-05-27"
		}
	]
}

### GET
* /stock/
* /stock/{id}
