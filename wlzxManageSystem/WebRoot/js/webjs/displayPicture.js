$(function(){
    showPicture();  // 图片展示
});

// img存放要展示的图片
var img=[
    {
        'alt':'图片1',
        'src':'images/webimg/displayPicture/1_b.jpg',
        'smallSrc':'images/webimg/displayPicture/1_s.jpg'
    },{
        'alt':'图片2',
        'src':'images/webimg/displayPicture/2_b.jpg',
        'smallSrc':'images/webimg/displayPicture/2_s.jpg'
    },{
        'alt':'图片3',
        'src':'images/webimg/displayPicture/3_b.jpg',
        'smallSrc':'images/webimg/displayPicture/3_s.jpg'
    },{
        'alt':'图片4',
        'src':'images/webimg/displayPicture/4_b.jpg',
        'smallSrc':'images/webimg/displayPicture/4_s.jpg'
    },{
        'alt':'图片5',
        'src':'images/webimg/displayPicture/5_b.jpg',
        'smallSrc':'images/webimg/displayPicture/5_s.jpg'
    },{
        'alt':'图片6',
        'src':'images/webimg/displayPicture/6_b.jpg',
        'smallSrc':'images/webimg/displayPicture/6_s.jpg'
    },{
        'alt':'图片7',
        'src':'images/webimg/displayPicture/7_b.jpg',
        'smallSrc':'images/webimg/displayPicture/7_s.jpg'
    },{
        'alt':'图片8',
        'src':'images/webimg/displayPicture/8_b.jpg',
        'smallSrc':'images/webimg/displayPicture/8_s.jpg'
    },{
        'alt':'图片9',
        'src':'images/webimg/displayPicture/9_b.jpg',
        'smallSrc':'images/webimg/displayPicture/9_s.jpg'
    },{
        'alt':'图片10',
        'src':'images/webimg/displayPicture/1_b.jpg',
        'smallSrc':'images/webimg/displayPicture/1_s.jpg'
    },{
        'alt':'图片11',
        'src':'images/webimg/displayPicture/2_b.jpg',
        'smallSrc':'images/webimg/displayPicture/2_s.jpg'
    },{
        'alt':'图片12',
        'src':'images/webimg/displayPicture/3_b.jpg',
        'smallSrc':'images/webimg/displayPicture/3_s.jpg'
    },{
        'alt':'图片13',
        'src':'images/webimg/displayPicture/4_b.jpg',
        'smallSrc':'images/webimg/displayPicture/4_s.jpg'
    },{
        'alt':'图片14',
        'src':'images/webimg/displayPicture/5_b.jpg',
        'smallSrc':'images/webimg/displayPicture/5_s.jpg'
    },{
        'alt':'图片15',
        'src':'images/webimg/displayPicture/6_b.jpg',
        'smallSrc':'images/webimg/displayPicture/6_s.jpg'
    },{
        'alt':'图片16',
        'src':'images/webimg/displayPicture/7_b.jpg',
        'smallSrc':'images/webimg/displayPicture/7_s.jpg'
    },{
        'alt':'图片17',
        'src':'images/webimg/displayPicture/8_b.jpg',
        'smallSrc':'images/webimg/displayPicture/8_s.jpg'
    },{
        'alt':'图片18',
        'src':'images/webimg/displayPicture/9_b.jpg',
        'smallSrc':'images/webimg/displayPicture/9_s.jpg'
    }
];

/**
 * 图片展示
 */
function showPicture(){
    var i=0,  // 大图编号
        len=img.length,  // img数组的长度(img:展示的图片)
        cur= 0,  // 当前小图编号
        j=9,  // 默认显示小图个数
        page=0,  // 小图的页码
        $s_pre=$('#smallImg_pre'),  // 小图上一页
        $s_next=$('#smallImg_next'),  // 小图下一页
        box=$('#smallImg_box').width(),  // 小图展示区的长度
        $ul=$('#smallImg_ul'),  // 小图外层
        $imgLi=$ul.find('li'),  // 小图li
        html=_html='';  // 存放载入的代码

    $('#detailImg_box').append('<a class=\"detailImg_1\"><img alt=\"'+img[0].alt+'\" src=\"'+img[i].src+'\"></a>');

    // 大图展示区点击上一页
    $('#detailImg_pre').click(function(){
		if(i==0){  // 当显示到第一张图片时，再点击上一张就显示最后一张
			detailImg_click($s_pre,len-1,len);
			i=len-1;
		}else{
			--i;
        	detailImg_click($s_pre,i,len);
		}     
    });
    // 大图展示区点击下一页
    $('#detailImg_next').click(function(){
		if(i==len-1){  // 当显示到最后一张图片时，再点击下一张就显示第一张
			detailImg_click($s_next,0,len);
			i=0;
		}else{
			++i;
        	detailImg_click($s_next,i,len);
		}    
    });

    // 小图
    for(var k=0;k<j;k++){
        var _k=k%len;
        s_html(_k);
        html+=h;
    }
    $ul.append(html);
    $('.smallImg_1').addClass('cur');

    // 小图展示区点击上一页
    $('#smallImg_pre').click(function(){
        if(!$ul.is(':animated')){
            page--;
            var a=(page-1)*j,_a,c;
            for(var k=0;k<j;k++,a--){
                smallImg_click(a,_a,len,i);
                _html=h+_html;
            }
            $ul.prepend(_html).css({'right':box,'left':'auto'});
            $ul.animate({right:0},1600,function(){
                $ul.find('li:gt('+(j-1)+')').detach();  // 删除后9个li,从8开始
                _html='';
            });
            $('#smallImg_ul li').click(function(){
                var _this=$(this);
                i=_this.attr('class').replace(/[^0-9]/ig,'')-1;
                img_info(i);
                s_a_r(_this,'cur');
                cur=i;
            })
        }

    });

    // 小图展示区点击下一页
    $('#smallImg_next').click(function(){
        if(!$ul.is(':animated')){
            page++;
            var a=page*j,_a,c;
            for(var k=0;k<j;k++,a++){
                smallImg_click(a,_a,len,i);
                _html+=h;
            }
            $ul.append(_html);
            $ul.css({'left':0,'right':'auto'});
            $ul.animate({left:-box},1600,function(){
                $ul.find('li:lt('+j+')').detach();
                $ul.css('left',0);
                _html='';
            });  // 动画执行后,再删除前9个li,将left设回0
            $('#smallImg_ul li').click(function(){  // 三处一样，不知道这个要怎么优化？？？
                var _this=$(this);
                i=_this.attr('class').replace(/[^0-9]/ig,'')-1;
                img_info(i);
                s_a_r(_this,'cur');
                cur=i;
            })
        }
    });

    // 点击小图
    $('#smallImg_ul li').click(function(){
        var _this=$(this);
        i=_this.attr('class').replace(/[^0-9]/ig,'')-1;
        img_info(i);
        s_a_r(_this,'cur');
        cur=i;
    });

    // 鼠标经过图片时显示上一页和下一页的按钮
    $('#detailImg_box').find('img').mouseover(function(){
        $('#detailImg_pre').css('opacity','0.5');
        $('#detailImg_next').css('opacity','0.5');
    });
    // 鼠标移出图片时隐藏上一页和下一页的按钮
    $('#detailImg_box').find('img').mouseout(function(){
        $('#detailImg_pre').css('opacity','0');
        $('#detailImg_next').css('opacity','0');
    });
    // 鼠标经过上一页按钮时透明度加深
    $('#detailImg_pre').mouseover(function(){
        $('#detailImg_pre').css('opacity','0.8');
        $('#detailImg_next').css('opacity','0.5');
    });
    // 鼠标经过下一页按钮时透明度加深
    $('#detailImg_next').mouseover(function(){
        $('#detailImg_next').css('opacity','0.8');
        $('#detailImg_pre').css('opacity','0.5');
    });
}


/**
 * 大图图片信息
 */
function img_info(i){
	var alt=img[i].alt,
		src=img[i].src,
		$main=$('#detailImg_box');
	$main.find('a').attr({'class':'detailImg_'+(i+1)});
	$main.find('img').attr({'alt':alt,'src':src});
}

/**
 * 大图左右点击
 */
function detailImg_click($pn,i,len){
	i_cur(i,len);
	img_info(i);
	var imgCur=$('.smallImg_'+(i+1));
	if(!imgCur.html()){
		$pn.click();
	} 
	s_a_r($('.smallImg_'+(i+1)),'cur');  // 小图选中
}

/**
 * 小图左右点击
 */
function smallImg_click(a,_a,len,i){
	_a=a;
	_a=a%len;
	if(_a<0){
		_a+=len;
	}
	c=_a==i?'cur':'';
	s_html(_a,c);
}

function s_a_r(o,c){
	o.addClass(c).siblings().removeClass(c);
}

function i_cur(i,len){
	i=i%len;
	if(i<0){
		i=len+i;
	}
	return i;	
}

function s_html(_a,c){
	return h='<li class=\"smallImg_'+(_a+1)+' '+c+'\"><a><img alt=\"'+img[_a].alt+'\" src=\"'+img[_a].smallSrc+'\"></a></li>';
}