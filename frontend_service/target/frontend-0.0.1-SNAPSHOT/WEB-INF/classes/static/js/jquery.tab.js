(function(a){a.ui=a.ui||{};a.fn.tab=function(b){return this.each(function(){var c=a.extend({},b);if(c!==false){new a.ui.tab(this,c)}})};a.ui.tab=function(c,b){this.settings=a.extend({},a.ui.tab.settings,b);this.element=a(c);this.refresh();this.attachEvents()};a.ui.tab.prototype={refresh:function(){this.tabs=this.element.find(this.settings.tabs);this.box=this.element.find(this.settings.box);this.index=typeof this.settings.index=="function"?this.settings.index.call(this):this.settings.index;if(this.index<0||this.index>this.element.find(this.settings.tabs).length-1){this.index=0}if(this.settings.cookies){this.index=a.cookie(this.settings.cookies)==null?this.index:a.cookie(this.settings.cookies)}this.tabs.removeClass(this.settings.cur).eq(this.index).addClass(this.settings.cur);this.box.hide().eq(this.index).show();if(this.settings.onSet){this.settings.onSet(this)}},attachEvents:function(){var b=this;this.tabs.each(function(d){var e=a(this),f=b.settings.evtype.toLowerCase(),c=(f=="mouseover"||f=="mouseenter");e.bind(b.settings.evtype,function(g){if(!e.hasClass(b.settings.cur)){b.index=d;if(b.settings.cookies){a.cookie(b.settings.cookies,b.index)}var h=function(){this.tabs.removeClass(this.settings.cur).eq(d).addClass(this.settings.cur);this.box.hide().eq(d).show()};if(c){clearTimeout(b.timer);b.timer=setTimeout(function(){h.call(b);h=null},b.settings.delay)}else{h.call(b);h=null}if(b.settings.onSelect){b.settings.onSelect(b)}g.stopPropagation();return false}});if(c){e.mouseleave(function(){clearTimeout(b.timer)})}})}};a.extend(a.ui.tab,{settings:{delay:300,tabs:">ol li",index:0,cur:"officecur",evtype:"click",box:">.main",cookies:false,onSet:undefined,onSelect:undefined}})})(jQuery);
