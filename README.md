# WebScrapper
WebScrapper using Jsoup library

The web scrapper will be given the following inputs:
•	URL
•	Depth Level
 
The web scrapper should scrape the given website to the provided depth and maintaining the hierarchy.
Example: 
•	Consider example.com as depth level zero
•	Now the page received at example.com contains 3 more URL then these URL will be considered as depth level 1.
•	If any of the above 3 contain any URLs then these will be considered as depth level 2.
•	And so on.


Steps to run test :- 
1. Download the repo and import it in the Eclipse workspace.
2. Include the jar files in lib folder as build dependency and build the project.
3. Change the rootUrl value (if needed).Change the depth level by changing the depth variable value.
4. For testing it locally.Run local UI server(use python's Simplehttpserver) where DummyHTML folder(in the repo) resides.
5. Change the rootUrl value to your local UI server's IP.
6. Run the program.


This code when run on files in DummyHTML folder,provides following output :-

Data populated
http://localhost:8000/root.html 0
http://localhost:8000/layer/first.html 1
http://localhost:8000/layer/second.html 1
http://localhost:8000/layer/third.html 2
http://localhost:8000/layer/fourth.html 2
http://localhost:8000/layer/fifth.html 2

Note :- Output format is URL and level(Depth) at which url was encountered.
