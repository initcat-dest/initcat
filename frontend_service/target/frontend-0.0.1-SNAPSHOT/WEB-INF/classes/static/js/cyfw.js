var i=-1; //第i+1个tab开始
$(document).ready(function(){
	for ( var i = 1; i <= 3; i++) {
		initServiceboxlist('serviceboxlist_mark'+i, 'serviceboxlist'+i);
	}
	initServiceboxlist('serviceboxlist_mark103', 'serviceboxlist103');
});
function initServiceboxlist(desId, commonClass){
	$('#'+desId+' em:first').addClass('emon');
	$('.'+commonClass+':first').css('display','block');
	autoroll(desId);
	hookThumb(desId, commonClass);
}
function autoroll(desId){
	var n = $('#'+desId+' em').length-1;
	i++;
	if(i > n){
		i = 0;
	}
}

function slide(i, desId, commonClass){
	$('#'+desId+' em').eq(i).addClass('emon').siblings().removeClass('emon');
	$('.'+commonClass).eq(i).css('display','block').siblings('.'+commonClass).css('display','none');
}

function hookThumb(desId, commonClass){
	$('#'+desId+' em').hover(function(){
			i = $(this).prevAll().length;
			slide(i, desId, commonClass); 
	},function(){
		this.blur();
		return false;
	}); 
}