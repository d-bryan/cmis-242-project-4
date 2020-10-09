# Test Plan

| Test | Process | Parcel ID | Address | Bdrs | Sq Ft | Price | Status | Window Display | Message |
|------|---------|-----------|---------|------|-------|-------|--------|----------------|---------|
| 1 | Find | 9999 | | | | | | | Parcel ID Does Not Exist |
| 2 | Insert | 9999 | 14 Main Ave | 5 | 3452 | 354500 | FOR_SALE | Success Inserting 9999 14 Main Ave 5 Bedrooms 3452 sq ft $354,500 FOR_SALE | |
| 3 | Find | 9999 | | | | | | Record in Database 9999 14 Main Ave 5 Bedrooms 3452 sq ft $354,500 FOR_SALE  |  |
| 4 | Insert | 9999 | | | | | | | Parcel ID Exists |
---------------------------------------------------------------------------------------------------
