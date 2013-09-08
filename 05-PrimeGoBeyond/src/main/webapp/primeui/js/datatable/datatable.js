$(function(){$.widget("primeui.puidatatable",{options:{columns:null,datasource:null,paginator:null,selectionMode:null,rowSelect:null,rowUnselect:null,caption:null},_create:function(){this.id=this.element.attr("id");
if(!this.id){this.id=this.element.uniqueId().attr("id")
}this.element.addClass("pui-datatable ui-widget");
this.tableWrapper=$('<div class="pui-datatable-tablewrapper" />').appendTo(this.element);
this.table=$("<table><thead></thead><tbody></tbody></table>").appendTo(this.tableWrapper);
this.thead=this.table.children("thead");
this.tbody=this.table.children("tbody").addClass("pui-datatable-data");
if(this.options.datasource){if($.isArray(this.options.datasource)){this.data=this.options.datasource;
this._initialize()
}else{if($.type(this.options.datasource)==="function"){this.options.datasource.call(this,this._handleDataLoad)
}}}},_initialize:function(){var a=this;
if(this.options.columns){$.each(this.options.columns,function(c,b){var d=$('<th class="ui-state-default"></th>').data("field",b.field).appendTo(a.thead);
if(b.headerText){d.text(b.headerText)
}if(b.sortable){d.addClass("pui-sortable-column").data("order",1).append('<span class="pui-sortable-column-icon ui-icon ui-icon-carat-2-n-s"></span>')
}})
}if(this.options.caption){this.table.prepend('<caption class="pui-datatable-caption ui-widget-header">'+this.options.caption+"</caption>")
}if(this.options.paginator){this.options.paginator.paginate=function(b){a.paginate()
};
this.options.paginator.totalRecords=this.options.paginator.totalRecords||this.data.length;
this.paginator=$("<div></div>").insertAfter(this.tableWrapper).puipaginator(this.options.paginator)
}if(this._isSortingEnabled()){this._initSorting()
}if(this.options.selectionMode){this._initSelection()
}this._renderData()
},_handleDataLoad:function(a){this.data=a;
if(!this.data){this.data=[]
}this._initialize()
},_initSorting:function(){var b=this,a=this.thead.children("th.pui-sortable-column");
a.on("mouseover.puidatatable",function(){var c=$(this);
if(!c.hasClass("ui-state-active")){c.addClass("ui-state-hover")
}}).on("mouseout.puidatatable",function(){var c=$(this);
if(!c.hasClass("ui-state-active")){c.removeClass("ui-state-hover")
}}).on("click.puidatatable",function(){var d=$(this),e=d.data("field"),c=d.data("order"),f=d.children(".pui-sortable-column-icon");
d.siblings().filter(".ui-state-active").data("order",1).removeClass("ui-state-active").children("span.pui-sortable-column-icon").removeClass("ui-icon-triangle-1-n ui-icon-triangle-1-s");
b.sort(e,c);
d.data("order",-1*c);
d.removeClass("ui-state-hover").addClass("ui-state-active");
if(c===-1){f.removeClass("ui-icon-triangle-1-n").addClass("ui-icon-triangle-1-s")
}else{if(c===1){f.removeClass("ui-icon-triangle-1-s").addClass("ui-icon-triangle-1-n")
}}})
},paginate:function(){this._renderData()
},sort:function(b,a){this.data.sort(function(d,g){var f=d[b],e=g[b],c=(f<e)?-1:(f>e)?1:0;
return(a*c)
});
if(this.options.selectionMode){this.selection=[]
}if(this.paginator){this.paginator.puipaginator("option","page",0)
}this._renderData()
},sortByField:function(d,c){var f=d.name.toLowerCase();
var e=c.name.toLowerCase();
return((f<e)?-1:((f>e)?1:0))
},_renderData:function(){if(this.data){this.tbody.html("");
var f=this.getFirst(),k=this.getRows();
for(var e=f;
e<(f+k);
e++){var b=this.data[e];
if(b){var h=$('<tr class="ui-widget-content" />').appendTo(this.tbody),g=(e%2===0)?"pui-datatable-even":"pui-datatable-odd";
h.addClass(g);
if(this.options.selectionMode&&PUI.inArray(this.selection,e)){h.addClass("ui-state-highlight")
}for(var d=0;
d<this.options.columns.length;
d++){var c=$("<td />").appendTo(h),a=b[this.options.columns[d].field];
c.text(a)
}}}}},getFirst:function(){if(this.paginator){var b=this.paginator.puipaginator("option","page"),a=this.paginator.puipaginator("option","rows");
return(b*a)
}else{return 0
}},getRows:function(){return this.paginator?this.paginator.puipaginator("option","rows"):this.data.length
},_isSortingEnabled:function(){var b=this.options.columns;
if(b){for(var a=0;
a<b.length;
a++){if(b[a].sortable){return true
}}}return false
},_initSelection:function(){var a=this;
this.selection=[];
this.rowSelector="#"+this.id+" tbody.pui-datatable-data > tr.ui-widget-content:not(.ui-datatable-empty-message)";
if(this._isMultipleSelection()){this.originRowIndex=0;
this.cursorIndex=null
}$(document).off("mouseover.puidatatable mouseout.puidatatable click.puidatatable",this.rowSelector).on("mouseover.datatable",this.rowSelector,null,function(){var b=$(this);
if(!b.hasClass("ui-state-highlight")){b.addClass("ui-state-hover")
}}).on("mouseout.datatable",this.rowSelector,null,function(){var b=$(this);
if(!b.hasClass("ui-state-highlight")){b.removeClass("ui-state-hover")
}}).on("click.datatable",this.rowSelector,null,function(b){a._onRowClick(b,this)
})
},_onRowClick:function(d,c){if(!$(d.target).is(":input,:button,a")){var f=$(c),b=f.hasClass("ui-state-highlight"),e=d.metaKey||d.ctrlKey,a=d.shiftKey;
if(b&&e){this.unselectRow(f)
}else{if(this._isSingleSelection()||(this._isMultipleSelection()&&!e&&!a)){this.unselectAllRows()
}this.selectRow(f)
}PUI.clearSelection()
}},_isSingleSelection:function(){return this.options.selectionMode==="single"
},_isMultipleSelection:function(){return this.options.selectionMode==="multiple"
},unselectAllRows:function(){this.tbody.children("tr.ui-state-highlight").removeClass("ui-state-highlight").attr("aria-selected",false);
this.selection=[]
},unselectRow:function(b,a){var c=this._getRowIndex(b);
b.removeClass("ui-state-highlight").attr("aria-selected",false);
this._removeSelection(c);
if(!a){this._trigger("rowUnselect",null,this.data[c])
}},selectRow:function(b,a){var c=this._getRowIndex(b);
b.removeClass("ui-state-hover").addClass("ui-state-highlight").attr("aria-selected",true);
this._addSelection(c);
if(!a){this._trigger("rowSelect",null,this.data[c])
}},_removeSelection:function(a){this.selection=$.grep(this.selection,function(b){return b!==a
})
},_addSelection:function(a){if(!this._isSelected(a)){this.selection.push(a)
}},_isSelected:function(a){return PUI.inArray(this.selection,a)
},_getRowIndex:function(b){var a=b.index();
return this.options.paginator?this.getFirst()+a:a
}})
});