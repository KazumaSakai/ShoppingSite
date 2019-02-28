## 概要
| プロジェクト名 | ShoppingSite                                      |
|:--------------|:--------------------------------------------------|
| 説明          | 様々な商品を、販売会社が販売しているショッピングサイト |

## 主な機能
- **非ログイン**  

| 機能名　　　　　　　　　　 | Action                              | JSP               |
|:-------------------------|:------------------------------------|:------------------|
| 商品一覧表示機能　　　　　 | [ProductListAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/ProductListAction.java)                    | [ProductList.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/ProductList.jsp)     |
| 商品検索機能　　　　　　　 | [ProductListAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/ProductListAction.java)                   | [ProductList.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/ProductList.jsp)    |
| 商品詳細情報表示機能　　　 | [ProductInfoAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/ProductInfoAction.java)                    | [ProductInfo.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/ProductInfo.jsp)     |
| 会社情報表示機能　　　　　 | [CompanyInfoAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/CompanyInfoAction.java)                    | [Company.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/Company.jsp)         |
| ユーザー情報表示機能　　　 | [UserAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/UserAction.java)                           | [User.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/User.jsp)            |
| ログイン機能　　　　　　　 | [LoginAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/LoginAction.java)                          | [Login.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/Login.jsp)           |
| 新規登録機能　　　　　　　 | [SignUpAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/SignUpAction.java)                         | [SignUp.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/SignUp.jsp)          |
| 認証ログイン機能　　　　　 | [GoogleLoginAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/GoogleLoginAction.java)                    | [Login.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/Login.jsp)           |
| 認証登録機能　　　　　　　 | [GoogleLoginAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/GoogleLoginAction.java)                    | [SignUp.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/SignUp.jsp)          |

- **一般ユーザー**  

| 機能名　　　　　　　　　　 | Action                              | JSP                    |
|:-------------------------|:------------------------------------|:-----------------------|
| マイカート機能　　　　　　 | [CartAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/CartAction.java)                            | [Cart.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/Cart.jsp)                 |
| カート商品追加機能　　　　 | [IncrementProductQuantityAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/IncrementProductQuantityAction.java)      | [Cart.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/Cart.jsp)                 |
| カート商品数減少機能　　　 | [DecrementCartProductQuantityAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/DecrementCartProductQuantityAction.java)  | [Cart.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/Cart.jsp)                 |
| カート商品削除機能　　　　 | [DeleteCartProductAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/DeleteCartProductAction.java)             | [Cart.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/Cart.jsp)                 |
| カート合計金額機能　　　　 | [PriceAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/PriceAction.java)                         | [Template.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/Template.jsp)             |
| 配達情報設定機能　　　　　 | [GoBuyAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/GoBuyAction.java)                         | [DestinationSelect.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/DestinationSelect.jsp)    |
| 商品購入機能　　　　　　　 | [SettlementCartAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/SettlementCartAction.java)                | [SettlementComplete.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/SettlementComplete.jsp)   |
| ユーザー情報機能　　　　　 | [UserInfoAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/UserInfoAction.java)　　　　　             | [UserPage.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/UserPage.jsp)             |
| ユーザー名変更機能　　　　 | [UpdateUserNameAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/UpdateUserNameAction.java)                | [UserInfo.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/UserInfo.jsp)             |
| パスワード変更機能　　　　 | [UpdateUserPasswordAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/UpdateUserPasswordAction.java)            | [UserInfo.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/UserInfo.jsp)             |
| 購入履歴表示機能　　　　　 | [PurchaseHistoryAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/PurchaseHistoryAction.java)               | [PurchaseHistory.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/PurchaseHistory.jsp)      |
| 購入履歴削除機能　　　　　 | [PurchaseHistoryDeleteAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/PurchaseHistoryDeleteAction.java)         | [PurchaseHistory.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/PurchaseHistory.jsp)      |
| 宛先一覧表示機能　　　　　 | [DestinationListAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/DestinationListAction.java)               | [DestinationList.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/DestinationList.jsp)      |
| 宛先登録機能　　　　　　　 | [InsertDestinationAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/InsertDestinationAction.java)             | [InsertDestination.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/InsertDestination.jsp)    |
| レビュー投稿機能　　　　　 | [PostProductReviewAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/PostProductReviewAction.java)             | [ProductReviewList.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/ProductReviewList.jsp)    |
| レビュー削除機能　　　　　 | [DeleteProductReviewAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/DeleteProductReviewAction.java)           | [ProductReviewList.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/ProductReviewList.jsp)    |
| ログアウト機能　　　　　　 | [LogoutAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/LogoutAction.java)                        | [Logout.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/Logout.jsp)               |

- **管理者**  

| 機能名　　　　　　　　　　 | Action                              | JSP                      |
|:-------------------------|:------------------------------------|:-------------------------|
| ユーザー一覧機能          | [AdminUserListAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/AdminUserListAction.java)                   | [UserList.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/UserList.jsp)              |
| ユーザー削除機能          | [AdminDeleteUserAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/AdminDeleteUserAction.java)                | [UserList.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/UserList.jsp)              |
| 商品追加機能　　          | [AdminInsertProductAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/AdminInsertProductAction.java)             | [InsertProduct.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/InsertProduct.jsp)         |
| すべての購入履歴表示機能　 | [AdminPurchaseHistoryAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/AdminPurchaseHistoryAction.java)           | [PurchaseHistoryList.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/PurchaseHistoryList.jsp)   |
| 商品売り上げ情報表示機能　 | [ProductSalesAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/ProductSalesAction.java)                   | [PurchaseSales.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/PurchaseSales.jsp)         |
| 商品情報変更機能　　　　　 | [AdminUpdateProductAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/AdminUpdateProductAction.java)             | [ProductInfo.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/ProductInfo.jsp)           |
| 商品在庫追加機能　　　　　 | [AdminIncrementProductQuantityAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/AdminIncrementProductQuantityAction.java)  | [ProductInfo.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/ProductInfo.jsp)           |
| 商品削除機能　　　　　　　 | [AdminDeleteProductAction](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/src/com/internousdev/ShoppingSite/action/product/AdminDeleteProductAction.java)             | [ProductList.jsp](https://github.com/KazumaSakai/ShoppingSite/blob/master/ShoppingSite/WebContent/Product/ProductList.jsp)           |

## 開発環境

| ---           | カレッジ                    | 自宅        |
|:--------------|:---------------------------|:------------|
| OS　　　　　   | NEC VersaPRO Window7   | Windows10   |
| 統合開発環境　 | Eclipse4.6.3   | Eclipse4.5  |
| データベース　 | Mysql          | ---         |
| 使用言語　　　 | JAVA         　　 | ---         |
| フレームワーク | Struts2      | ---         |

## 開発期間

2019/01/15 ~ 2019/02/28


