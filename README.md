# SaveMoney

目的:當初的目的是想說旅遊需要存錢,則我想到做一個存錢系統


功能:  <br>
       • 存儲當日所要存的金額 <br>
	     • 首頁會顯示以前到現在所存的加總金額 <br>
	     • 歷史紀錄按鈕會紀錄當下存錢的日期、時間與當下存的金額 <br>
	     • 重置按鈕會跳出提示視窗,此按鈕會將系統所有紀錄清空 <br>
	     • 資料會儲存到SQLite

未來展望: <br>
     • 版面要美化 <br>
		 • 歷史紀錄可以做刪除 <br>
	   • 功能要增加領錢系統 <br>

## Main 

<img src="https://github.com/TinaLebron/SaveMoney/raw/master/main_1.png" width="250" />

| Option | Description |
| ------ | ----------- |
| reset (重置)   | All datas will be re-recorded. |
| total money (總金額) | All current amounts. |
| deposit (存錢)   | If you want to save money , you can write down.  |
| historical record (歷史紀錄) | All datas was putin. |

## Save Money 

&nbsp;
<img src="https://github.com/TinaLebron/SaveMoney/raw/master/saveMoney.png" width="250" />

| Option | Description |
| ------ | ----------- |
| back   | return to previous page. |
| save you money (存錢) | Amount deposited. |
| ok    | The data will be written to the database.|

## Reset


<img src="https://github.com/TinaLebron/SaveMoney/raw/master/warning.png" width="250" />&nbsp;
<img src="https://github.com/TinaLebron/SaveMoney/raw/master/main_2.png" width="250" />

| Option | Description |
| ------ | ----------- |
| alert dialog (警告對話框)  | if you want to re-record,you must pull yes boutton. |

## Historical Record 

&nbsp;
<img src="https://github.com/TinaLebron/SaveMoney/raw/master/historicalRecord.png" width="250" />

| Option | Description |
| ------ | ----------- |
| historical record (歷史紀錄) | It can show the amount of money stored and the current time. |



