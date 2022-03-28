	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
	<div id="footer-background">
	
	
		<footer>
		
		 <!-- 본문가리지 않는 플로팅배너 모듈 -->
				<a style="POSITION: fixed; RIGHT: 1%; BOTTOM: 2%;" href="http://pf.kakao.com/_Cxjpwb/chat" target="_blank">
							<img src="../../..${pageContext.request.contextPath}/resources/hyunwoo/imageContainer/kakaoLogo.png" style="width: 60px; height: 60px;"> 
				</a>
				<!-- 모듈 끝 -->
		

			
			<div>
				<p id="company-name">(주) 방방술래</p>
				<p class="company-info">
					서울시 비트구 캠프로 123, 5층
					<span class="vertical-divider hide--mobile">&nbsp;&nbsp;|&nbsp;&nbsp;</span>
					<br class="show--mobile"/>

				</p>
				<p class="company-info">
					문의 &nbsp;bangbang@bang.co
					<span class="vertical-divider hide--mobile">&nbsp;&nbsp;|&nbsp;&nbsp;</span>
					<br class="show--mobile"/>
					<span class="space show--mobile"></span>
					&nbsp;&nbsp;
					<a href="mailto:contact@dailyshot.co" target="_blank">
						
					</a>
				</p>

				<p id="company-paper-links">
					<a>사업자정보확인</a>
					<span class="vertical-divider">&nbsp;&nbsp;|&nbsp;&nbsp;</span>
					<a>이용약관</a>
					<span class="vertical-divider">&nbsp;&nbsp;|&nbsp;&nbsp;</span>
					<a>개인정보취급방침</a>
				</p>

				
			</div>
		</footer>
	</div>


    
  </body>
</html> 








<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


  <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/hyunwoo/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/hyunwoo/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/hyunwoo/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/hyunwoo/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/hyunwoo/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/hyunwoo/dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
        $(".sidebar-nav")
        .attr("class", "sidebar-nav navbar-collapse collapse")
        .attr("aria-expanded", 'false')
        .attr("style", "height:1px");
        
        
    });
    
   
    
    
    
    </script>
    
    
    
    
    