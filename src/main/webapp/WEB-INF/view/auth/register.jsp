<%@include file="/WEB-INF/view/dynamic/header.jspf" %>
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
      <a href='<c:url value="/"/>' class="nav-link">&#8592; Back</a>
      <div class="row justify-content-center">
         <div class="col-md-12 heading-section text-center ftco-animate mb-5">
            <h2 class="mb-2">Register</h2>
            <h3 class="mb-2" style="color:red;">${error}</h3>
         </div>
      </div>
      <div class="row">
         <div class="col-md-12">
            <form method="post" action='<c:url value="/register"/>'>
               <div class="form-group">
                  <label class="label">Nickname</label>
                  <input type="text" class="form-control" placeholder="nickname" name="nick" value="${user.nick}" required  autocomplete="off">
               </div>
               <div class="form-group">
                  <label class="label">Password</label>
                  <input type="password" class="form-control" placeholder="password" name="password" value="${user.password}" required  autocomplete="off">
               </div>
               <div class="form-group">
                  <label class="label">E-mail</label>
                  <input type="email" class="form-control" placeholder="e-mail" name="email" value="${user.email}" required  autocomplete="off">
               </div>
               <div class="form-group">
                  <label class="label">First Name</label>
                  <input type="text" class="form-control" placeholder="first Name" name="firstName" value="${user.firstName}" required  autocomplete="off">
               </div>
               <div class="form-group">
                  <label class="label">Last Name</label>
                  <input type="text" class="form-control" placeholder="last Name" name="lastName" value="${user.lastName}" required  autocomplete="off">
               </div>
               <div class="form-group">
                  <label class="label">Phone number</label>
                  <input type="tel" class="form-control" placeholder="phone number" name="phoneNumber" value="${user.phoneNumber}" pattern="[0-9]{9}" maxlength="9" required  autocomplete="off">
               </div>
               <div class="form-group">
                  <input type="submit" value="Sign up" class="btn btn-secondary px-4">
               </div>
            </form>
         </div>
      </div>
   </div>
</section>
<%@include file="/WEB-INF/view/dynamic/footer.jspf" %>