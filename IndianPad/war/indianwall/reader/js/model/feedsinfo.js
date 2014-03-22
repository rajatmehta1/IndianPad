var app = app || {};



app.FeedsInfo = Backbone.Model.extend({

       

       initialize: function() {

              console.log('FeedsInfo is initialized');

       },

       

    defaults: {

       feedCount : 0,

       pageSizeCnt : 0

    },

    

    urlRoot: '/FeedServlet'

       

});
