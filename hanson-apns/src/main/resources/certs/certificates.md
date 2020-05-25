# Certificates 

## Create a self signed certificate

- create the key

```shell script
openssl genpkey -algorithm RSA -des3 -out private-key.pem -pkeyopt rsa_keygen_bits:4096
```

> Notes: 
> - pwd: changeme

- create the csr

```shell script
openssl req -new -key private-key.pem -out csr.pem
```

- create the self signed certificate

```shell script
openssl x509 -in csr.pem -out certificate.pem -req -signkey private-key.pem -days 365
```