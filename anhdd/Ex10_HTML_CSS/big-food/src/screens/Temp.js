import React, { Component } from 'react'

export default class Temp extends Component {
  render() {
    return (
        <div className="row">
        <div className="col-lg-4 col-md-4 col-sm-12 col-xs-12 hidden-sm">
            <div className="product_index_banner banner_effect">
            <a href="#" title="Banner 1" className="banner_1">
                <img className="img-responsive center-base lazyload loaded" src="//bizweb.dktcdn.net/100/053/643/themes/877493/assets/banner-3.jpg?1663747576101" data-src="//bizweb.dktcdn.net/100/053/643/themes/877493/assets/banner-3.jpg?1663747576101" alt="Banner 1" data-was-processed="true" />
            </a>
            </div>
        </div>
        <div className="col-lg-8 col-md-8 col-sm-12 col-xs-12">
            <div className="product_index_banner banner_effect">
            <a href="#" title="Banner 2" className="banner_2">
                <img className="img-responsive center-base lazyload loaded" src="//bizweb.dktcdn.net/100/053/643/themes/877493/assets/banner-4.jpg?1663747576101" data-src="//bizweb.dktcdn.net/100/053/643/themes/877493/assets/banner-4.jpg?1663747576101" alt="Banner 2" data-was-processed="true" />
            </a>
            </div>
        </div>
        </div>

    )
  }
}
