==========================
ADDING ENTITIES IN POSTMAN
==========================
=====
CURRENCY
=====
{
    "name": "Australian Dollar",
    "symbol": "AUD"
}
=====
EQUITY
=====
{
    "name": "Google",
    "symbol": "GOOG"
}
=====
EXCHANGE
=====
{
    "name": "London Stock Exchange",
    "symbol": "LSE"
}
=====
ADDRESS
=====
{
	"line1": "10 High Street",
	"line2": "aa",
	"line3": "aa",
	"city": "Bath",
	"county": "BANES",
	"postcode": "BA11 3QE"
}
======
COUNTERPARTY
======
{
    "emailAddress": "dealer@myco.com",
    "name": "Bill Smith",
    "phoneNumber": "0122267876",
    "address": {
        "id": 1,
        "line1": "10 High Street",
        "line2": "aa",
        "line3": "aa",
        "city": "Bath",
        "county": "BANES",
        "postcode": "BA11 3QE"
    }
}
{
    "emailAddress": "phoebe@infotech.co.uk",
    "name": "Phoebe Byrne",
    "phoneNumber": "0970234321",
    "address": {
        "id": 15,
        "line1": "1 DEF Road",
        "line2": null,
        "line3": null,
        "city": "Newcastle",
        "county": "Tyne and Wear",
        "postcode": "NE1 1CD"
    }
}
=====
EQUITY TRADE
=====
{
    "counterParty1": {
        "id": 2,
        "name": "Bill Smith",
        "phoneNumber": "0122267876",
        "emailAddress": "dealer@myco.com",
        "address": {
            "id": 1,
            "line1": "10 High Street",
            "line2": "aa",
            "line3": "aa",
            "city": "Bath",
            "county": "BANES",
            "postcode": "BA11 3QE"
        }
    },
    "counterParty2": {
        "id": 3,
        "name": "Jane Doe",
        "phoneNumber": "0122278987",
        "emailAddress": "dealer2@pimco.com",
        "address": {
            "id": 12,
            "line1": "27 Tennyson Road",
            "line2": null,
            "line3": null,
            "city": "Southampton",
            "county": "Hampshire",
            "postcode": "SO1 1AA"
        }
    },
    "agreementDate": "2022-11-14",
    "equity": {
        "id": 6,
        "name": "Google",
        "symbol": "GOOG"
    },
    "currency": {
        "id": 1,
        "name": "Sterling",
        "symbol": "GBP"
    },
    "exchange": {
        "id": 11,
        "name": "London Stock Exchange",
        "symbol": "LSE"
    },
    "amount": 1000,
    "price": 1000.50
}

