<div class="container-fluid">
		<div class="row justify-content-center"></div>
		<form:form modelAttribute="employee" action="" method="post">
			<div class="form-group">
				<label for="name">名前</label>
				<form:errors path="name" cssClass="text-danger" element="p" />
				<form:input cssClass="form-control" path="name" />
			</div>
			<div class="for-group">
				<form:select cssClass="form-control" path="department.id"
					items="${departments}" itemLabel="name" itemValue="id"></form:select>
			</div>
			<div class="form-group">
				<label for="phone">電話番号</label>
				<form:errors cssClass="text-danger" path="phone" element="p" />
				<form:input cssClass="form-control" path="phone" />
			</div>
			<div class="form-group">
				<label for="address">住所</label>
				<form:textarea cssClass="form-control" path="address" />
			</div>
			<div class="form-group">
				<label for="note">備考</label>
				<form:textarea cssClass="form-control" path="note" />
			</div>
			<div class="form-group">
				<label for="loginId">ログインID</label>
				<form:errors path="loginId" cssClass="text-danger" element="p" />
				<form:input path="loginId" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label for="loginPass">ログインパスワード</label>
				<form:errors path="loginPass" cssClass="text-danger" element="p" />
				<form:password path="loginPass" cssClass="form-control" />
			</div>
			<div class="form-proup">
				<input class="form-control btn btn-primary" type="submit" value="送る">
			</div>
		</form:form>
	</div>