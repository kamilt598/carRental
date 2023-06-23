<%@include file="dynamic/header.jspf" %>
<div class="hero-wrap ftco-degree-bg" style="background-image: url('/resources/images/bg_1.jpg');"
   data-stellar-background-ratio="0.5">
   <div class="overlay"></div>
   <div class="container">
      <div class="row no-gutters slider-text justify-content-start align-items-center justify-content-center">
         <div class="col-lg-8 ftco-animate">
            <div class="text w-100 text-center mb-md-5 pb-md-5">
               <h1 class="mb-4">Fast &amp; Easy Way To Rent A Car</h1>
               <p style="font-size: 18px;">CHOOSE - RENT - ENJOY!</p>
            </div>
         </div>
      </div>
   </div>
</div>
<section class="ftco-section ftco-no-pt bg-light">
   <div class="container">
      <div class="row justify-content-center">
         <div class="col-md-12 heading-section text-center ftco-animate mb-5">
            <h2 class="mb-2">Sign in</h2>
         </div>
      </div>
      <div class="row">
         <div class="col-md-12">
            <form method="post" action='<c:url value="/login"/>'>
               <div class="form-group">
                  <label class="label">Nickname</label>
                  <input type="text" class="form-control" placeholder="nickname" name="nick">
               </div>
               <div class="form-group">
                  <label class="label">Password</label>
                  <input type="password" class="form-control" placeholder="password" name="password">
               </div>
               <div class="form-group">
                  <input type="submit" value="Sign in" class="btn btn-secondary px-4">
               </div>
            </form>
            <div class="form-group">
               <label class="label">Don't hava an account?</label>
               <a href='<c:url value="/register"/>' role="button" class="btn btn-secondary px-4">Sign Up</a>
            </div>
         </div>
      </div>
   </div>
</section>
<%@include file="dynamic/footer.jspf" %>