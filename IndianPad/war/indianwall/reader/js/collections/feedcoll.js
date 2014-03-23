var app = app || {};



app.FeedColl = Backbone.Collection.extend({

                initialize: function() {

                                //console.log("collection intiliazed");

                },

                model: app.Feed,

                url: '/TestServlet?rssLink=ttn'

});
