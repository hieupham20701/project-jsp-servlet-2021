
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách bài viết</title>
</head>
<body>
	<div class="main-content">
	<form action="<c:url value='/admin-new'/>" id="formsubmit" method="get">
	
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>Tên bài viết</th>
													<th>Mô tả ngắn</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="a" items="${model.listResult}">
													<tr>
														<td>${a.title}</td>
														<td>${a.shortDescription}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<ul class="pagination" id="pagination"></ul>
										<input type="hidden" value="" id="page" name="page"/>
										<input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			</form>
		</div>

	<!-- /.main-content -->
	<script type="text/javascript">
		var totalPage = ${model.totalPage};
		var currentPage = ${model.page};
		var limit= 2;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPage,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if(currentPage != page){
						$("#maxPageItem").val(limit);
						$("#page").val(page);
						$("#formsubmit").submit();
					}
				}
			});
		});
	</script>
</body>
</html>