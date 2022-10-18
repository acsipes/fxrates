package demo.OITM;

import java.math.BigDecimal;
import java.util.Objects;

class Ticker {
    String symbol;
    BigDecimal tradedPrice;

    @Override
    public int hashCode() {
  final int prime = 31;
  int result = super.hashCode();
  result = prime * result + Objects.hash(symbol, tradedPrice);
  return result;
    }

    @Override
    public boolean equals(Object obj) {
  if(this == obj)
    return true;
  if(!super.equals(obj))
    return false;
  if(getClass() != obj.getClass())
    return false;
  Ticker other = (Ticker) obj;
  return Objects.equals(symbol, other.symbol);
    }






}
