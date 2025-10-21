Feature: SSO login for brands

  @SSO
  Scenario Outline: Authorize via SSO and measure timings for <brand>
    Given brand "<brand>" config is loaded
    When user opens account page
    Then measure time until SSO login button is clickable
    When user enters username "<username>" and password "<password>" on MyAcc
    And user clicks SSO login button
    And user clicks first "Log In" button on redirected page
    Then measure time until home page is fully loaded
    And log timings and result

    Examples:
      | brand            | username | password |
      | https://light-trading.99xtrade.com | demo_all@i.ua | Dev123123 |
      | https://light-trading.airmarkets.sbs | demo_all@i.ua | Dev123123 |
      | https://light-trading.avpfx-demo.org | demo_all1@i.ua | Dev123123 |
      | https://light-trading.avpfx.org | demo_all@i.ua | Dev123123 |
      | https://light-trading.braviatrade.org | demo_all@i.ua | Dev123123 |
      | https://light-trading.capitalprime.org | demo_all@i.ua | Dev123123 |
      | https://light-trading.capitalprof.cfd | demo_all@i.ua | Dev123123 |
      | https://light-trading.dowmarkets.com | demo_all@i.ua | Dev123123 |
      | https://light-trading.fiovation.com | demo_all@i.ua | Dev123123 |
      | https://light-trading.firamarkets.com | demo_all@i.ua | Dev123123 |
      | https://light-trading.forexby.com | demo_all@i.ua | Dev123123 |
      | https://light-trading.goldflame.io | demo_all@i.ua | Dev123123 |
      | https://light-trading.greenwavex.ai | demo_all@i.ua | Dev123123 |
      | https://light-trading.greenwavex.com | demo_all@i.ua | Dev123123 |
      | https://light-trading.grow-line.org | demo_all@i.ua | Dev123123 |
      | https://light-trading.investingvip.com | demo_all@i.ua | Dev123123 |
      | https://light-trading.irotradex.com | demo_all@i.ua | Dev123123 |
      | https://light-trading.lamdatrade.me | demo_new@i.ua | Dev123123 |
      | https://light-trading.lamdatradeua.com | demo_all@i.ua | Dev123123 |
      | https://light-trading.lexatrade.org | demo_all@i.ua | Dev123123 |
      | https://light-trading.limefx.ac | demo_all@i.ua | Dev123123 |
      | https://light-trading.lunarcapital.org | demo_all@i.ua | Dev123123 |
      | https://light-trading.markets60.top | demo_all@i.ua | Dev123123 |
      | https://light-trading.maxi-trade.com | demo_all@i.ua | Dev123123 |
      | https://light-trading.maximarkets.lc | demo_all@i.ua | Dev123123! |
      | https://light-trading.maxitrade.com | demo_all@i.ua | Dev123123 |
      | https://light-trading.nexytrade.com | demo_all@i.ua | Dev123123 |
      | https://light-trading.oceanmarkets.biz | demo_all@i.ua | Dev123123 |
      | https://light-trading.protradex.biz | demo_all@i.ua | Dev123123 |
      | https://light-trading.prtrend.cfd | demo_all@i.ua | Dev123123 |
      | https://light-trading.quantrotrade.net | demo_all@i.ua | Dev123123 |
      | https://light-trading.rangercapital.pro | demo_all@i.ua | Dev123123 |
      | https://light-trading.startcapital.io | demo_all@i.ua | Dev123123! |
      | https://light-trading.tradeallcrypto.sbs | demo_all@i.ua | Dev123123! |
      | https://light-trading.traderprof.com | demo_all@i.ua | Dev123123 |
      | https://light-trading.tradeyatra.org | demo_all@i.ua | Dev123123 |
      | https://light-trading.tradiva.com | demo_all@i.ua | Dev123123 |
      | https://light-trading.tredero.com | demo_all@i.ua | Dev123123 |
      | https://light-trading.ucapitals.co | demo_all@i.ua | Dev123123 |
      | https://light-trading.umarkets.id | demo_all@i.ua | Dev123123! |
      | https://light-trading.vedafx.com | q111024@dunkos.xyz | leoZ173y |
      | https://light-trading.worldtradex.io | demo_all@i.ua | Dev123123! |
      | https://light-trading.xcindia.com | demo_all@i.ua | Dev123123 |
