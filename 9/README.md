CRC Картууд

1. Класс: Warehouse
Хариуцлага:
-Бараа хүлээн авах (receiveGoods)
-Бараа зарлага гаргах (issueGoods)
-Нөөцийн тайлан гаргах (generateReport)
-Тооллого хийх (performStocktaking)
Хамтран ажиллагчид:
-Clerk
-Receipt
-IssueSlip
-InventoryItem
-InventoryReport
-StocktakingRecord

2. Класс: Clerk
Хариуцлага:
-Орлогын падаан үүсгэх (createReceipt)
-Зарлагын падаан үүсгэх (createIssueSlip)
-Нөөцийн тайлан харах (viewReport)
-Тооллого хийх (performStocktaking)
Хамтран ажиллагчид:
-Warehouse
-Receipt
-IssueSlip
-InventoryReport
-StocktakingRecord

3. Класс: InventoryItem
-Хариуцлага:
-Барааны мэдээллийг хадгалах (код, нэр, тоо хэмжээ)
-Тоо хэмжээг шинэчлэх (updateQuantity)
Хамтран ажиллагчид:
-Receipt
-IssueSlip
-StocktakingRecord

4. Класс: Receipt
Хариуцлага:
-Орлогын падааны мэдээллийг хадгалах (бараанууд, хүлээлгэн өгсөн хүн, огноо)
Хамтран ажиллагчид:
-InventoryItem
-Warehouse
5. Класс: IssueSlip
Хариуцлага:
-Зарлагын падааны мэдээллийг хадгалах (бараанууд, хүлээн авсан хүн, огноо)
Хамтран ажиллагчид:
-InventoryItem
-Warehouse

6. Класс: InventoryReport
Хариуцлага:
-Нөөцийн тайлангийн мэдээллийг хадгалах (эхлэх огноо, дуусах огноо, бараанууд)
Хамтран ажиллагчид:
-InventoryItem
-Warehouse

7. Класс: StocktakingRecord
Хариуцлага:
-Тооллогын бүртгэлийн мэдээллийг хадгалах (бараа, бодит тоо хэмжээ, огноо)
Хамтран ажиллагчид:
-InventoryItem
-Warehouse