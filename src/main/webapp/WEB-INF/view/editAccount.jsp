<%@include file="dynamic/header.jspf"%>
<div class="hero-wrap ftco-degree-bg" style="background-image: url('/resources/images/bg_1.jpg');" data-stellar-background-ratio="0.5">
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
      <a href='<c:url value="/my-account"/>' class="nav-link">&#8592; Back</a>
      <div class="row justify-content-center">
         <div class="col-md-12 heading-section text-center ftco-animate mb-5">
            <h2 class="mb-2">My account</h2>
            <h3 class="mb-2" style="color:red;">${error}</h3>
         </div>
      </div>
      <form method="post" action='<c:url value="/edit-account"/>'>
      <div class="row" style="display: flex;justify-content: center;align-items: center;">
         <div class="col-md-5">
            <h4 align="center">Nick</h4>
         </div>
         <div class="col-md-7">
            <input type="text" class="form-control" value="${user.nick}" name="nick" required>
         </div>
      </div>
      <hr style="height:2px;border-width:0;color:gray;background-color:gray">
      <div class="row" style="display: flex;justify-content: center;align-items: center;">
         <div class="col-md-5">
            <h4 align="center">First name</h4>
         </div>
         <div class="col-md-7">
            <input type="text" class="form-control" value="${user.firstName}" name="firstName" required>
         </div>
      </div>
      <hr style="height:2px;border-width:0;color:gray;background-color:gray">
      <div class="row" style="display: flex;justify-content: center;align-items: center;">
         <div class="col-md-5">
            <h4 align="center">Last name</h4>
         </div>
         <div class="col-md-7">
            <input type="text" class="form-control" value="${user.lastName}" name="lastName" required>
         </div>
      </div>
      <hr style="height:2px;border-width:0;color:gray;background-color:gray">
      <div class="row" style="display: flex;justify-content: center;align-items: center;">
         <div class="col-md-5">
            <h4 align="center">e-mail</h4>
         </div>
         <div class="col-md-7">
            <input type="email" class="form-control" value="${user.email}" name="email" required>
         </div>
      </div>
      <hr style="height:2px;border-width:0;color:gray;background-color:gray">
      <div class="row" style="display: flex;justify-content: center;align-items: center;">
         <div class="col-md-5">
            <h4 align="center">Phone number</h4>
         </div>
         <div class="col-md-7">
            <input type="tel" class="form-control" value="${user.phoneNumber}" name="phoneNumber" pattern="[0-9]{9}" maxlength="9" required>
         </div>
      </div>
      <hr style="height:2px;border-width:0;color:gray;background-color:gray">
      <div class="row" style="display: flex;justify-content: center;align-items: center;">
         <div class="col-md-5">
            <h4 align="center">Password</h4>
         </div>
         <div class="col-md-7">
            <input type="password" class="form-control" name="password">
         </div>
      </div>
      <hr style="height:2px;border-width:0;color:gray;background-color:gray">
      <div class="row" style="display: flex;justify-content: center;align-items: center;">
        <div class="col-md-6" align="center">
            <input type="submit" value="Save" class="btn btn-secondary px-4">
        </div>
      </div>
      </form>
   </div>
</section>
<%@include file="dynamic/footer.jspf"%>