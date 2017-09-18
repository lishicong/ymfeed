<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
.paginator-active {
	background: #e9ecef;
}
</style>
<script type="text/javascript" src="js/jqPaginator.js"></script>

<!-- Pagination -->
<ul class="pagination justify-content-center" id="ym-pagination"></ul>

<script>
	var YmPaginator = function() {
		var me = this;
		var PAGE_NUMBER = 3;

		me.init = function(total) {

			var page = Math.ceil(total / PAGE_NUMBER);

			$.jqPaginator('#ym-pagination', {
				totalPages : page,
				visiblePages : 5,
				currentPage : 1,
				prev : '<li class="prev page-link"><a href="javascript:;">&laquo;</a></li>',
				next : '<li class="next page-link"><a href="javascript:;">&raquo;</a></li>',
				page : '<li class="page page-link"><a href="javascript:;">{{page}}</a></li>',
				onPageChange : function(num, type) {
					//$('#p2').text(type + '：' + num);
					me.changePage(num);
				}
			});
		}

		me.changePage = function(num) {
			ymChangePage(num);
		}

		return me;
	}

	var ymPaginator = new YmPaginator();
</script>
