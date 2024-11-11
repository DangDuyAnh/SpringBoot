import React, { Component } from 'react'
import './Homepage2.css'

export default class Homepage2 extends Component {
  render() {
    return (
<div className="htop section">
  <div className="bg-topbar">
    <div className="container">
      <div className="row">
        <div className="first">
          <span>Chào mừng bạn đến với bigFood!</span>
        </div>
        <div className="second">
          <div className="link_top">
            <ul className="list-menu">
              <li className="first-hidden-xs"><a href="/"><span>Trang chủ</span></a></li>
              <li className=" hidden-xs"><a href="/gioi-thieu"><span>Giới thiệu</span></a></li>
              <li className=" hidden-xs"><a href="/collections/all"><span>Sản phẩm</span></a></li>
              <li className=" hidden-xs"><a href="/san-pham-khuyen-mai"><span>Khuyến mãi</span></a></li>
              <li className=" hidden-xs"><a href="/tin-tuc"><span>Tin tức</span></a></li>
              <li className=" hidden-xs"><a href="/lien-he"><span>Liên hệ</span></a></li>
              <li className="account"><span>Tài khoản</span>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

    )
  }
}
