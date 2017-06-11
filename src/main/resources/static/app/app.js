/**
 * Created by niwantha on 3/12/17.
 */

var app=angular.module('datavis',[
     'ngRoute',
    'ngCookies',
    'ngFileUpload',
    'ngResource',
    'chart.js',


    //add all controller
    'datavis.controllers',
    //'ngFileUpload',
    'myApp',




    //add all config
    'datavis.config',

    //add all services
    'datavis.services'
]);
