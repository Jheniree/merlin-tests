function fn()  {
    var config = {
        baseUrl : 'https://petstore.swagger.io/v2'
    };

    karate.configure('logPrettyResponse', true);

    return config;
}