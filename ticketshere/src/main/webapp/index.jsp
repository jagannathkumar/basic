<html>
    <style>
        fieldset{
            width: 600px;
            margin: auto;
            background-color: lightblue;
            border-radius: 10px;
        }
        input[type=date],select{
            width:auto;
            margin: 8px 0px;
            padding: 10px 20px;
            font-size: 20px;
            border-radius: 5px;
        }
        input[type=text]{
            width:auto;
            margin: 8px 0px;
            padding: 10px 20px;
            font-size: 20px;
            border-radius: 5px;
        }
        button{
            width:100px;
            padding: 10px 20px;
            background-color: chocolate;
            color: aliceblue;
            border-radius: 5px; 
            cursor: pointer;           
        }
    </style>
    
    <head></head>
    <body>
        <fieldset>
        <form action="bookt">
            <h2 style="text-align:center">Book Ticket</h2>
            <table cellspacing="30">
                <tr>
                    <td style="font-size:20px">
                        Theatre: 
                    </td>
                    <td>
                        <select name="theater">
                            <option value="Keshari">Keshari</option>
                            <option value="Inox">INOX</option>
                            <option value="Maharaja">Maharaja</option>
                            <option value="S Complex">S Complex</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td style="font-size:20px">
                        Date: 
                    </td>
                    <td>
                        <input type="date" name="date" min="2018-04-01" max="2018-04-12">
                    </td>
                </tr>
                <tr>
                    <td style="font-size:20px">
                        Time: 
                    </td>
                    <td>
                        <select name="timing">
                            <option value="9am-12pm">9am-12pm</option>
                            <option value="1pm-4pm">1pm-4pm</option>
                            <option value="5pm-8pm">5pm-8pm</option>
                        </select>
                    </td>
                </tr>
                
                <tr>
                    <td style="font-size:20px">
                        Name: 
                    </td>
                    <td>
                        <input type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <td style="font-size:20px">
                        Gender: 
                    </td>
                    <td>
                        <input type="radio" name="gender" value="Male">Male
                        <input type="radio" name="gender" value="Female">Female
                    </td>
                </tr>
                <tr>
                    <td style="font-size:20px">
                        Email: 
                    </td>
                    <td>
                        <input type="text" pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}$" placeholder="abc@xyz.com" name="email" required>
                    </td>
                </tr>
                <tr>
                    <td style="font-size:20px">
                        Topup: 
                    </td>
                    <td>
                        <select name="topup">
                            <option value="food">Food</option>
                            <option value="drinks">Drinks</option>
                            <option value="food and drinks">Food and Drinks</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><button type="submit">Book</button></td>
                    <td><button type="reset">Cancel</button></td>
                </tr>
            </table>
        </form>
    </fieldset>
    </body>
</html>