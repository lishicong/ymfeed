<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style type="text/css">
.navbar-toggler {
	z-index: 1;
}

@media ( max-width : 767px) {
	nav>.container {
		width: 100%;
	}
}

.ym_logo {
	width: 146px;
}

.ym_logo_ic {
	width: 36px;
	height: 36px;
	margin-left: 12px;
}

@media ( max-width : 767px) {
	.ym_logo_ic {
		margin-left: 0px;
	}
}

.ym_logo_title {
	font-weight: bold;
	font-size: 1.2rem;
	color: #000000;
	vertical-align: middle;
}

.ym_logo_title:focus, .ym_logo_title:hover {
	text-decoration: none;
	color: #000000;
}
</style>

<!-- Navigation -->
<nav class="navbar fixed-top navbar-toggleable-md navbar-light bg-faded">


	<!-- logo -->
	<div class="ym_logo">
		<img src="images/ic_logo.png" class="ym_logo_ic"> <a
			class="ym_logo_title" href="index">薅羊毛</a>
	</div>

</nav>
