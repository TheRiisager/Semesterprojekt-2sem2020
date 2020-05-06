<jsp:include page="header.jsp"/>

    <form name="savedesign" action="FrontController" method="POST" oninput="x.value=Math.round( ( parseInt(a.value) / 100 ) * ( parseInt(b.value) / 100 ) )">
        <input type="hidden" name="target" value="savedesign">
        <h2> Insert length here</h2>
        <input type="number" name= "length" value = "" id="a"><br>
        <h2> insert width here</h2>
        <input type="number" name="width" value="" id="b"><br>
        <h2> Din carports areal er: <output name="x"  for="a b"></output>m2</h2>

        <input type="submit" value="Gem design">
    </form>

<jsp:include page="footer.jsp"/>
