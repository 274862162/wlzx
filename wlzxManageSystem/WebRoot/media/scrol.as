//new scrol(movieToScroll,scrolltrack,scrollHandler) 
package {
	import flash.display.MovieClip;
	import flash.display.Sprite;
	import flash.geom.Rectangle;
	import flash.events.*;
	//import flash.system.System;

	public class scrol extends MovieClip {
		//System.useCodePage = true;
		private var scrollHeight:Number;
		private var contentHeight:Number;
		private var scrollFaceHeight:Number;
		private var maskHeight:Number;

		private var initailPosition:Number;
		private var initContentPos:Number;
		private var finalContentPos:Number;


		private var left:Number;
		private var top:Number;
		private var right:Number;
		private var bottom:Number;

		private var dy:Number=0;
		private var speed:Number=10;

		private var movieToScroll:MovieClip;
		private var scrolltrack:MovieClip;
		private var scrollHandler:MovieClip;
		private var masc:Sprite;
		private var easing:Number = .05;
		private var speedToScroll:Number = -3;
		private var buttonPressed:Boolean =  false;
		private var percent:Number;

		public function scrol(movieToScroll:MovieClip,scrolltrack:MovieClip,scrollHandler:MovieClip) {
			this.movieToScroll=movieToScroll;
			this.scrolltrack=scrolltrack;
			this.scrollHandler=scrollHandler;
			masc=new Sprite  ;
			scrollHandler.parent.addChild(masc);
			movieToScroll.mask=masc;
			drawMask();
			setPositionsAndInit();
			handleDrag();
			handleScroll();
		}
		public function initEnterFrame():void {
			addEventListener(Event.ENTER_FRAME,moveContent);
		}
		public function deleteEnterFrame():void {
			removeEventListener(Event.ENTER_FRAME,moveContent);
		}
		private function drawMask():void {
			masc.graphics.lineStyle(1,0x00FF00,1);
			masc.graphics.beginFill(0x00FF00,1);
			masc.graphics.lineTo(0,scrollHandler.parent.height);
			masc.graphics.lineTo(movieToScroll.width * -1,scrollHandler.parent.height);
			masc.graphics.lineTo(movieToScroll.width * -1,0);
			masc.graphics.endFill();
		}
		private function setPositionsAndInit():void {
			movieToScroll.y = scrolltrack.parent.y;
			contentHeight=movieToScroll.height;
			scrollHeight=scrolltrack.height;
			scrollFaceHeight=scrollHandler.height;
			maskHeight=masc.height;
			initailPosition=scrollHandler.y=scrolltrack.y;
			initContentPos=masc.y;
			finalContentPos=maskHeight - contentHeight + initContentPos;
			scrollHandler.buttonMode = true;

		}
		private function moveContent(e:Event):void {
			//setDragerPosition(8)
			contentHeight=movieToScroll.height;
			var moveVal:Number=(contentHeight - maskHeight) / (scrollHeight - scrollFaceHeight);
			var target:Number = scrollHandler.y * - moveVal;
			var speed:Number = (target - movieToScroll.y) * easing;
			if ((Math.round(target) == Math.round(movieToScroll.y += speed) || Math.round(target) == Math.round((movieToScroll.y += speed)-1)) && buttonPressed == false) {
				trace("ENTER FRAME DELETED");
				deleteEnterFrame();
			} else {
				//trace("CAN'T DELETING ENTER FRMAME")
			}
			if (contentHeight>= scrollHeight) {
				movieToScroll.y += speed;
			}else{
				movieToScroll.y = 0
			}
			trace(contentHeight)
			if (scrollHandler.y <0) {
				scrollHandler.y = 0;
			} else if (scrollHandler.y >scrolltrack.height-  scrollHandler.height) {
				scrollHandler.y = scrolltrack.height -  scrollHandler.height;
			}
			
		}
		private function handleDrag():void {
			scrollHandler.addEventListener(MouseEvent.MOUSE_DOWN, doDrag);
			scrollHandler.addEventListener(MouseEvent.MOUSE_UP, doNotDrag);
			scrollHandler.addEventListener(MouseEvent.MOUSE_OVER, doOver);
			scrollHandler.addEventListener(MouseEvent.MOUSE_OUT, doOut);
		}
		private function doOver(e:MouseEvent):void {
			e.target.gotoAndStop("s2");
		}
		private function doOut(e:MouseEvent):void {
			e.target.gotoAndStop("s1");
		}
		private function doDrag(w:MouseEvent):void {
			buttonPressed = true;
			initEnterFrame();
			scrollHandler.startDrag(false,new Rectangle(0,0,0,scrolltrack.height - scrollHandler.height));
		}
		public function doNotDrag(e:MouseEvent):void {
			buttonPressed = false;
			scrollHandler.stopDrag();

		}
		public function stpDrag():void {
			buttonPressed = false;
			scrollHandler.stopDrag();
		}
		public function handleScroll():void {
			movieToScroll.addEventListener(MouseEvent.MOUSE_WHEEL,onMouseEvent);

		}
		public function onMouseEvent(e:MouseEvent):void {
			scrollHandler.y += ((e.delta)* speedToScroll);
			initEnterFrame();
			if (scrollHandler.y <=0) {
				scrollHandler.y = 0;
			} else if (scrollHandler.y >scrolltrack.height - scrollHandler.height) {
				scrollHandler.y = scrolltrack.height - scrollHandler.height;
			}
		}
		public function setDragerPosition(nr:Number,ratio:Number):void {
			scrollHandler.y =nr * ((scrolltrack.height-scrollHandler.height)/ (ratio-1));
			initEnterFrame();
		}
		public function resetDrager():void {
			scrollHandler.y = 0;
			initEnterFrame();
		}
	}
}