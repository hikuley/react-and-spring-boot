### How to run Application? ###

A single command to run the frontend & backend below.

```sh
$ docker-compose up --build
```
after if you want to access to ui module
```sh
http://localhost:300
```
to check rest api 
```sh
http://localhost:3001/api
```

This project includes two part of module, first module is called 'server', second module is called 'ui'
I used many kinds of external libraries for server module and ui module.

* server
1. node-cache: I preferred this library because each request must be cached according to challenge requirements.
2. babel: I coded server with es6 and for transformation.
3. node-fetch: Instead of implementing XMLHttpRequest in Node.js to run browser-specific
4. babel-plugin-transform-decorators-legacy plugin: 
5. babel-plugin-transform-object-rest-spread plugin: to use feature of the es6 spread 

* ui
1. redux : I prefer redux to manage state of the each react component.
2. redux-saga : I prefer redux-saga to manage actions of the reduxt.

### The time you spent on the challenge ###
I spent 3 days on the challange, but If I had more time, I was able to write test cases for ui methods and server methods and I could make more component on the ui module.  
