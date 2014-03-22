var app = app || {};



app.FeedItem = Backbone.Model.extend({

       

       initialize: function() {

              console.log('FeedItem model is initialized');

       },

       

    defaults: {

       image: 'http://placehold.it/350x150',

        title: '',

        description: '',

        link: ''

    }

       

});
