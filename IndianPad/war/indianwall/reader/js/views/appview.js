var app = app || {};


app.AppView = Backbone.View.extend({
    el: '#mainContainer',
    
    template: _.template( $('#feed-template').html() ),
    
    progressbar_template : _.template( $('#progressbar-template').html() ),
    
    events: {
    'change select#category' : 'changeCategory',
    'change #language' : 'changeLanguage',
    'click #addContentBtnId':'changeContent'   
    },    
    
    initialize: function( initialFeeds ) {
    this.addProgressBar();
    template = _.template( $('#feed-template').html() );
        this.collection = new app.FeedColl();
        this.render(); 
        this.collection.fetch({reset: true});               
        this.listenTo( this.collection, 'add', this.renderFeed );
        this.listenTo( this.collection, 'reset', this.render ); // NEW     
    },
        
    render: function() {
    
    var modelObj = '';
    var k = 0;
    this.collection.each(function( item ) {
            this.renderFeed( item,k );
            k = k + 1;
        }, this );
    },
    
    renderFeed: function(item,i) {
    var feedItemsArr = item.get("entries");
    //console.log(feedItemsArr);
    var that = this;
    
    //this.$el.append(this.template(item.toJSON()));
    this.$("#readerContainer").append(this.template(item.toJSON()));
    
    var lastIndexVal = -1;
    $.each(feedItemsArr, function( index, value ) {
    
    if(index < 5) {
    that.$("#feedItemsDiv" + i + "-0").append(
    new app.FeedView( 
            { model: value }
            ).render().el
    );
    }
    
    if(index>=5 && index<10) {
    //console.log( index + ": " + value.title );
    var test = that.$("#feedItemsDiv" + i + "-1");
    //console.log(test);
    that.$("#feedItemsDiv" + i + "-1").append(
    new app.FeedView( 
            { model: value }
            ).render().el
    );     
    }
    
    if(index>=10 && index<15) {
    that.$("#feedItemsDiv" + i + "-2").append(
    new app.FeedView( 
            { model: value }
            ).render().el
    ); 
    }
    
    lastIndexVal = index;
//         that.$el.append(
//             new app.FeedView( 
//             { model: value }
//             ).render().el 
//             ); 
    });
    
    if(lastIndexVal >= 5 && lastIndexVal < 10) {
    that.$("#feedItemsParentDiv" + i + "-2").remove();
    }
    else if(lastIndexVal < 5) {
    that.$("#feedItemsParentDiv" + i + "-1").remove();
    }
    this.removeProgressBar();
    },
    
    changeContent: function() {
    //console.log('addEvent - came here');
    },
    
    changeCategory: function(e) {
        var catValue = $("#category").val();
        var langValue = $("#language").val();
        this.collection = new app.FeedColl();
        this.collection.fetch(
        {  
        reset: true,
        data : $.param({ category: catValue, language:langValue})
        }
        );
        this.render();  
    },
    
    changeLanguage: function(e) {
        var catValue = $("#category").val();
        var langValue = $("#language").val();
        this.$("#readerContainer").empty();
        this.addProgressBar();
        var that = this;
        
        this.collection.fetch(
        {
        reset: true,
        data : $.param({ category: catValue, language:langValue}),
        success: function() {
        that.removeProgressBar();
        }
        }
        );
          
      
    },
    
    addProgressBar: function() {
this.$("#readerContainer").append(this.progressbar_template());
this.$( "#progressbar" ).progressbar({
     value: false
});
    },
    
    removeProgressBar: function() {
    this.$("#progressbarCnt").remove();
    }
    
    
});
