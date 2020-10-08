# Example Test Plan

| Test | Process | Parcel ID | Address | Bdrs | Sq Ft | Price | Status | Window Display | Message |
|------|---------|-----------|---------|------|-------|-------|--------|----------------|---------|
| 1 | Find | 7623 | | | | | | | Parcel ID Does Not Exist |
| 2 | Insert | 7623 | 563 Main St | 4 | 2234 | 243212 | UNDER_CONTRACT | Success Inserting 7623 563 Main St 4 Bedrooms 2234 sq ft $243,212 UNDER_CONTRACT | |
| 3 | Find | 7623 | | | | | | Record in Database 7623 563 Main St 4 Bedrooms 2234 sq ft $243,212 UNDER_CONTRACT  |  |
| 4 | Insert | 7623 | | | | | | | Parcel ID Exists |
---------------------------------------------------------------------------------------------------
