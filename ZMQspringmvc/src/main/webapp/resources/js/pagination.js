var pagination = {
		pagerId				: "page",				//div的id
		pno					: 1,					//当前页码
		totalPages			: 1,					//总页码
		totalRecords		: 0,					//总数居数
		lang				: {
			prePageText		: "&lt;上一页",
			nextPageText	: "下一页&gt;"
		},
		click: function() {
			return false;
		},
		getHref: function(n) {
			return "#";
		},
		selectPage: function(n) {
			this._config["pno"] = n;
			this.generPageHtml(this._config, true);
		},
		//生成控件代码
		generPageHtml: function(config, enforceInit) {
			
			if(enforceInit || !this.inited) {
				this.init(config);
			}
			
			var str_prv = "", str_next = "";
			if(this.hasPrv) {
				str_prv = "<a " + this._getHandlerStr(this.prv) + " class='np'>" 
					+ this.lang.prePageText + "</a>";
			}
			if(this.hasNext) {
				str_next = "<a " + this._getHandlerStr(this.next) + " class='np'>" 
					+ this.lang.nextPageText + "</a>";
			}
			
			var str = "";
			//分页处理
			if(this.totalPages <= 10) {
				//只有一页时不显示页码
				if(this.totalPages > 1) {
					for(var i = 1; i <= this.totalPages; ++i) {
						if(this.pno == i) {
							str += "<strong><span class='pg'>"+i+"</span></strong>";
						} else {
							str += "<a "+ this._getHandlerStr(i) +"><span class='pg'>"+i+"</span></a>";
						}
					}
				}
			} else {
				if(this.pno > 6) {
					var endPage = this.pno + 4;
					endPage = endPage > this.totalPages ? this.totalPages : endPage;
					for(var i = this.pno-5; i <= endPage; ++i) {
						if(this.pno == i) {
							str += "<strong><span class='pg'>"+i+"</span></strong>";
						} else {
							str += "<a "+ this._getHandlerStr(i) +"><span class='pg'>"+i+"</span></a>";
						}
					}
				} else {
					for(var i = 1; i <= 10; ++i) {
						if(this.pno == i) {
							str += "<strong><span class='pg'>"+i+"</span></strong>";
						} else {
							str += "<a "+ this._getHandlerStr(i) +"><span class='pg'>"+i+"</span></a>";
						}
					}
				}
			}
			var pagerHtml = "<div>";
			pagerHtml += str_prv + str + str_next;
			pagerHtml += '</div><div style="clear:both;"></div>';
			
			$("#"+this.pagerId).html(pagerHtml);
		},
		init: function(config) {
			this.pno = isNaN(config.pno) ? 1 : parseInt(config.pno);
			this.totalPages = isNaN(config.totalPages) ? 1 : parseInt(config.totalPages);
			this.totalRecords = isNaN(config.totalRecords) ? 1 : parseInt(config.totalRecords);
			if(config.pagerId) { this.pagerId = config.pagerId; }
			if(config.lang) {
				for(var key in config.lang) {
					this.lang[key] = config.lang[key];
				}
			}
			if(config.click && typeof(config.click) == "function") { this.click = config.click; }
			this._config = config;
			if(this.pno < 1) { this.pno = 1; }
			this.totalPages = (this.totalPages <= 1) ? 1 : this.totalPages;
			if(this.pno > this.totalPages) { this.pno = this.totalPages; }
			this.prv = (this.pno <= 2) ? 1 : (this.pno-1);
			this.next = (this.pno > this.totalPages) ? this.totalPages : (this.pno+1);
			this.hasPrv = (this.pno > 1);
			this.hasNext = (this.pno < this.totalPages);
			
			this.inited = true;
		},
		_getHandlerStr: function(n) {
			return "href='"+this.getHref(n)+"' onclick='return pagination._clickHandler("+n+")'";
		},
		_clickHandler: function(n) {
			var res = false;
			if(this.click && typeof this.click == "function") {
				res = this.click.call(this, n) || false;
			}
			return res;
		}
		
	
};