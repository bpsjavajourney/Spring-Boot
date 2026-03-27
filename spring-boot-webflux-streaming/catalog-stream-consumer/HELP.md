# Getting Started

### Reference Documentation
What this service does
----------------------

This service acts as a relay between the client and the producer.

It accepts a list of catalog codes from the client
Forwards the request to the producer
Receives streamed chunks from the producer
Sends the same stream back to the client

It does not process or store data. It just streams it through.

How it works
----------------------
Client sends request with catalog codes
Consumer calls producer using WebClient
Producer streams chunked data
Consumer reads it as a stream (Flux)
Consumer immediately forwards each chunk to the client

No waiting for full response.

Endpoint
----------------------
POST /catalog/chunks/stream
or http://localhost:8082

Headers:
----------------------
Content-Type: application/json
Accept: text/event-stream

Request body
----------------------

{"codes":["CAT-1001","CAT-1002","CAT-1003","CAT-1004","CAT-1005","CAT-1006","CAT-1007","CAT-1008","CAT-1009","CAT-1010"]}

Response
----------------------

Stream of CatalogChunk objects.

Each response chunk contains:
catalog code
chunk number
total chunks
chunk size
partial data


{"code":"CAT-1001","chunkNumber":1,"totalChunks":5,"chunkSize":25,"details":[...]}
{"code":"CAT-1001","chunkNumber":2,"totalChunks":5,"chunkSize":25,"details":[...]}
{"code":"CAT-1002","chunkNumber":1,"totalChunks":5,"chunkSize":25,"details":[...]}

Producer dependency
----------------------
Producer URL: http://localhost:8081


How to run
----------------------

. Create a file request.json and place it under the folder for ex: \Desktop\request
. place above provided Request body  in the request.json and save it
. Open cmd prompt or PowerShell in windows
. Go to the folder D:\request  and execute below command

curl.exe -N -X POST "http://localhost:8082/catalog/feed/chunks/stream" `
  -H "Content-Type: application/json" `
  -H "Accept: text/event-stream" `
  --data-binary "@D:\request\request.json"
  
  
  Optionally request can be triggered from any client.
  
  
 Response will be received like below
--------------------------------------
  
  data:{"code":"CAT-1002","chunkNumber":2,"totalChunks":5,"chunkSize":25,"details":[{"detailId":"CAT-1002-DETAIL-26","attributeName":"attribute-26","attributeValue":"value-for-CAT-1002-26"},{"detailId":"CAT-1002-DETAIL-27","attributeName":"attribute-27","attributeValue":"value-for-CAT-1002-27"},{"detailId":"CAT-1002-DETAIL-28","attributeName":"attribute-28","attributeValue":"value-for-CAT-1002-28"},{"detailId":"CAT-1002-DETAIL-29","attributeName":"attribute-29","attributeValue":"value-for-CAT-1002-29"},{"detailId":"CAT-1002-DETAIL-30","attributeName":"attribute-30","attributeValue":"value-for-CAT-1002-30"},{"detailId":"CAT-1002-DETAIL-31","attributeName":"attribute-31","attributeValue":"value-for-CAT-1002-31"},{"detailId":"CAT-1002-DETAIL-32","attributeName":"attribute-32","attributeValue":"value-for-CAT-1002-32"},{"detailId":"CAT-1002-DETAIL-33","attributeName":"attribute-33","attributeValue":"value-for-CAT-1002-33"},{"detailId":"CAT-1002-DETAIL-34","attributeName":"attribute-34","attributeValue":"value-for-CAT-1002-34"},{"detailId":"CAT-1002-DETAIL-35","attributeName":"attribute-35","attributeValue":"value-for-CAT-1002-35"},{"detailId":"CAT-1002-DETAIL-36","attributeName":"attribute-36","attributeValue":"value-for-CAT-1002-36"},{"detailId":"CAT-1002-DETAIL-37","attributeName":"attribute-37","attributeValue":"value-for-CAT-1002-37"},{"detailId":"CAT-1002-DETAIL-38","attributeName":"attribute-38","attributeValue":"value-for-CAT-1002-38"},{"detailId":"CAT-1002-DETAIL-39","attributeName":"attribute-39","attributeValue":"value-for-CAT-1002-39"},{"detailId":"CAT-1002-DETAIL-40","attributeName":"attribute-40","attributeValue":"value-for-CAT-1002-40"},{"detailId":"CAT-1002-DETAIL-41","attributeName":"attribute-41","attributeValue":"value-for-CAT-1002-41"},{"detailId":"CAT-1002-DETAIL-42","attributeName":"attribute-42","attributeValue":"value-for-CAT-1002-42"},{"detailId":"CAT-1002-DETAIL-43","attributeName":"attribute-43","attributeValue":"value-for-CAT-1002-43"},{"detailId":"CAT-1002-DETAIL-44","attributeName":"attribute-44","attributeValue":"value-for-CAT-1002-44"},{"detailId":"CAT-1002-DETAIL-45","attributeName":"attribute-45","attributeValue":"value-for-CAT-1002-45"},{"detailId":"CAT-1002-DETAIL-46","attributeName":"attribute-46","attributeValue":"value-for-CAT-1002-46"},{"detailId":"CAT-1002-DETAIL-47","attributeName":"attribute-47","attributeValue":"value-for-CAT-1002-47"},{"detailId":"CAT-1002-DETAIL-48","attributeName":"attribute-48","attributeValue":"value-for-CAT-1002-48"},{"detailId":"CAT-1002-DETAIL-49","attributeName":"attribute-49","attributeValue":"value-for-CAT-1002-49"},{"detailId":"CAT-1002-DETAIL-50","attributeName":"attribute-50","attributeValue":"value-for-CAT-1002-50"}]}
  .......
  .......  
  .......
  



