var app = app || {};



app.Feed = Backbone.Model.extend({

       

       initialize: function() {

              //console.log('Feed is initialized');

       },

       

    defaults: {

       fid:'',

        title: '',

        description: '',

        link: '',

        entries:[]

    }

       

});
