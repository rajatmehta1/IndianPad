var app = app || {};



app.FeedView = Backbone.View.extend({

    

       tagName : 'div',

    

    template: _.template( $('#feed-item-template').html() ),



    render: function() {

        //this.el is what we defined in tagName. use $el to get access to jQuery html() function



       

       

        this.$el.html( this.template( this.model ) );

        

        if(this.model.image == null || this.model.image == "") {

              this.$("img").remove();

        }

        

        return this;

    }



});

